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
import java.util.List;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    List<ProdutosDTO> lista = new ArrayList<>();
    
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
    
    public List<ProdutosDTO> listarProdutos(){
        List<ProdutosDTO> lista = new ArrayList <>();
        try{
          conn= new conectaDAO().conexao();
          String sql = "SELECT * FROM  produtos ";
          st=conn.prepareStatement(sql);
          rs = st.executeQuery();
          
          while(rs.next()){
              ProdutosDTO pr= new ProdutosDTO();
              pr.setId(rs.getInt("id"));
              pr.setNome(rs.getString("nome"));
              pr.setValor(rs.getInt("valor"));
              pr.setStatus(rs.getString("status"));
              lista.add(pr);
              
              
              
          }
          
        
        
        
        
        }catch(Exception e ){
        JOptionPane.showMessageDialog(null, "ERRO AO listar "+e.getMessage());}
        
        return lista;
    }
    
    public void venderProduto(int id) {
    try {
      conn=  new conectaDAO().conexao();

        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        stmt.execute();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
  
  public List<ProdutosDTO> produtosVendidos(){
      List<ProdutosDTO> lista = new ArrayList<>();
      try{
          
          conn= new conectaDAO().conexao();
          String sql= "SELECT *FROM  produtos  where Status ='vendido'";
          PreparedStatement st = conn.prepareStatement(sql);
          rs = st.executeQuery();
          while(rs.next()){
          ProdutosDTO pr= new ProdutosDTO();
          
          pr.setId(rs.getInt("id"));
          pr.setNome(rs.getString("nome"));
          pr.setValor(rs.getInt("valor"));
          pr.setStatus(rs.getString("status"));
          lista.add(pr);
}
      
      
      
      
      }catch(Exception e){
          e.printStackTrace();
      }return lista;
  }
  public List<ProdutosDTO> listaVenda(){
    List<ProdutosDTO> lista = new ArrayList<>();
    try{
        conn = new conectaDAO().conexao();
        String sql = "SELECT* FROM produtos WHERE status = 'vendido'";
        
        PreparedStatement st = conn.prepareStatement(sql);
        rs=st.executeQuery();
        while(rs.next()){
          
            ProdutosDTO pr= new ProdutosDTO();
            pr.setId(rs.getInt("id"));
            pr.setNome(rs.getString("nome"));
            pr.setValor(rs.getInt("valor"));
            pr.setStatus(rs.getString("status"));
            lista.add(pr);}
        
    
    
    
    
    }catch(Exception e ){
        e.printStackTrace();
    }
    return lista;
  
  
  
  }
      
     
}
  
    
    
    
    
        


