package teste;

import java.io.IOException;
import java.sql.Connection;

import javax.swing.JOptionPane;

import conexao.Conexao;
import dao.EnderecoDAO;
import model.Endereco;
import service.ViacepService;

public class ProgramaInserir {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Endereco endereco = new Endereco();
		EnderecoDAO enderecodao = new EnderecoDAO(con);////////
		ViacepService viacepservice = new ViacepService();
		
		try {
			
			endereco = viacepservice.getEndereco(JOptionPane.showInputDialog("Digite o CEP"));
			
			endereco.setCep(endereco.getCep());
			endereco.setBairro(endereco.getBairro());
			endereco.setComplemento(endereco.getComplemento());
			endereco.setDdd(endereco.getDdd());
			endereco.setGia(endereco.getGia());
			endereco.setIbge(endereco.getIbge());
			endereco.setLocalidade(endereco.getLocalidade());
			endereco.setLogradouro(endereco.getLogradouro());
			endereco.setSiafi(endereco.getSiafi());
			endereco.setUf(endereco.getUf());
			System.out.println(enderecodao.inserir(endereco));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Conexao.fecharConexao(con);
	}

}
