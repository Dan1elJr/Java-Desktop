package model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import db.DB;
import db.DbException;
import model.dao.RegistroDao;
import model.entities.Registro;


public class RegistroDaoJDBC implements RegistroDao{
	
	Connection conn = null;
	
	public RegistroDaoJDBC (Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Registro> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Registro> list= new ArrayList<>();
		try {
			
			pst = conn.prepareStatement(
					"SELECT * FROM registros"
					+"WHERE registro.Id = ?"
					);
																		//Mapeamento objeto relacional
			
			rs = pst.executeQuery();
			if(rs.next()) {
				Registro reg = instantiateRegistro(rs);
				list.add(reg);
					
			}
			
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			
			
		}
		return list;
	}

	@Override
	public void insert(Registro obj) {
		PreparedStatement pst = null;
		
		try {
			pst = conn.prepareStatement(
					"INSERT INTO registros "
					+"(linha, maquina, problema, causa, solucao) "
					+"VALUES "
					+"(?, ?, ?, ?, ?) "
					,Statement.RETURN_GENERATED_KEYS
					);													//Mapeamento objeto relacional
			
			pst.setLong(1, obj.getLinha());
			pst.setString(2, obj.getMaquina());
			pst.setString(3, obj.getProblema());
			pst.setString(4, obj.getCausa());
			pst.setString(5, obj.getSolucao());
			
			int rowsAffected = pst.executeUpdate();
			
			if(rowsAffected >0) {
				ResultSet rs = pst.getGeneratedKeys();
				
				while(rs.next()) {
					
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
				
			}
			else {
				throw new  DbException("Unexpected error! No rows Affected!");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(pst);
		}
	}

	@Override
	public void update(Registro obj) {
		PreparedStatement pst = null;
		
		try {
			pst = conn.prepareStatement(
					"UPDATE registros "
					+"SET Linha = ?, Maquina = ?, Problema = ?, Causa = ?, Solucao = ? "
					+"WHERE Id = ? "
					);
																		//Mapeamento objeto relacional
			pst.setInt(1, obj.getLinha());
			pst.setString(2, obj.getMaquina());
			pst.setString(3, obj.getProblema());
			pst.setString(4, obj.getCausa());
			pst.setString(5, obj.getSolucao());
			pst.setInt(6, obj.getId());
			
			pst.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(pst);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement pst = null;
		
		try {
			pst = conn.prepareStatement(
					"DELETE FROM registros "
					+"WHERE Id = ? "
					);
																		//Mapeamento objeto relacional
			pst.setInt(1, id);
			
			int rowsAffected = pst.executeUpdate();
			
			if(rowsAffected == 0) {
				throw new DbException("Error! the Id Does not exist!");
			}
			
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(pst);
		}
		
	}

	@Override
	public Registro findById(Integer id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = conn.prepareStatement(
					"SELECT * "
					+"FROM registros "
					+"WHERE registros.id = ?"
					);
																		//Mapeamento objeto relacional
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				Registro reg = instantiateRegistro(rs);
				
				
				return reg;
				
			}
			return null;
		}	
		catch(SQLException e) {
				
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}
		
		
		
		
		
	}
	
	//Função auxiliar para instanciar um objeto do tipo Registro
	private Registro instantiateRegistro(ResultSet rs) throws SQLException {
		Registro obj = new Registro(0, 0, null, null, null, null);
		
		obj.setId(rs.getInt("id"));
		obj.setLinha(rs.getInt("linha"));
		obj.setMaquina(rs.getString("maquina"));
		obj.setProblema(rs.getString("problema"));
		obj.setCausa(rs.getString("causa"));
		obj.setSolucao(rs.getString("solucao"));
		return obj;
	}

	
	

	
	

}