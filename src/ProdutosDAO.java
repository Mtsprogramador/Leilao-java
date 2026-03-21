/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement st;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto) throws SQLException{
    String sql= "INSERT INTO produtos (nome,valor,status)VALUES(?,?,?)";
    conn = new conectaDAO().conexao();    
    st= conn.prepareStatement(sql);
    st.setString(1,produto.getNome());
    st.setInt(2,produto.getValor());
    st.setString(3,produto.getStatus());
    st.execute();
    JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO ");
            
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

