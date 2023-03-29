package com.softlond.tallerPersistencia.repository;

import com.softlond.tallerPersistencia.models.Cuenta;
import com.softlond.tallerPersistencia.models.CuentaAhorros;
import com.softlond.tallerPersistencia.models.CuentaCorriente;

import java.sql.*;

public class CuentaRepositoryImpl implements ICuentaRepository {
    private String cadenaConexion;

    public CuentaRepositoryImpl() {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            cadenaConexion = "jdbc:sqlite:cuenta.db";
            crearTabla();
        } catch (SQLException e) {
            System.out.println("Error al registrar la base de datos " + e.getMessage());
        }
    }

    private void crearTabla() {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sql = "CREATE TABLE IF NOT EXISTS cuenta(" +
                    "numeroCuenta INTEGER PRIMARY KEY," +
                    "saldo INTEGER," +
                    "propietario TEXT," +
                    "tipoCuenta TEXT," +
                    "numeroDepositos INTEGER," +
                    "numeroRetiros INTEGER)";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos" + e.getMessage());
        }
    }

    @Override
    public Cuenta buscarCuenta(int numeroCuenta) {
        Cuenta cuenta = null;
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sql = "SELECT * FROM cuenta WHERE numeroCuenta = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, numeroCuenta);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet != null && resultSet.next()){
                int saldo = resultSet.getInt("saldo");
                String propietario = resultSet.getString("propietario");
                String tipoCuenta = resultSet.getString("tipoCuenta");
                int numeroDepositos = resultSet.getInt("numeroDepositos");
                int numeroRetiros = resultSet.getInt("numeroRetiros");
                if(tipoCuenta.equals("ahorro")){
                    cuenta = new CuentaAhorros(numeroCuenta, saldo, propietario);
                }else{
                    cuenta = new CuentaCorriente(numeroCuenta, saldo, propietario);
                }
            }

            return cuenta;
        } catch (SQLException e) {
            System.out.println("Error al buscar la cuenta" + e.getMessage());
        }
        return cuenta;
    }

    @Override
    public void guardarCuenta(Cuenta cuenta) {
        try(Connection conexion = DriverManager.getConnection(cadenaConexion)){
            String sql = "INSERT INTO cuenta(numeroCuenta, saldo, propietario, tipoCuenta, numeroDepositos, numeroRetiros) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, cuenta.getNumeroCuenta());
            preparedStatement.setInt(2, cuenta.getSaldo());
            preparedStatement.setString(3, cuenta.getPropietario());
            preparedStatement.setString(4, cuenta.getTipoCuenta());
            preparedStatement.setInt(5, cuenta.getNumeroDepositos());
            preparedStatement.setInt(6, cuenta.getNumeroRetiros());
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println("Error al guardar la cuenta" + e.getMessage());
        }
    }

    @Override
    public void actualizarCuenta(int numeroCuenta, Cuenta cuenta) {
        try(Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sql = "UPDATE cuenta SET saldo = ?, propietario = ?, tipoCuenta = ?, numeroDepositos = ?, numeroRetiros = ? WHERE numeroCuenta = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, cuenta.getSaldo());
            preparedStatement.setString(2, cuenta.getPropietario());
            preparedStatement.setString(3, cuenta.getTipoCuenta());
            preparedStatement.setInt(4, cuenta.getNumeroDepositos());
            preparedStatement.setInt(5, cuenta.getNumeroRetiros());
            preparedStatement.setInt(6, numeroCuenta);
            preparedStatement.execute();
        }catch (SQLException e){
            System.out.println("Error al actualizar la cuenta" + e.getMessage());
        }
    }

    @Override
    public void eliminarCuenta(int numeroCuenta) {

    }
}