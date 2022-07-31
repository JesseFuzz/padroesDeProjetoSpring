package service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Endereco;

/**
 * Client HTTP, criado via <b>OpenFeign</b>, para o consumo da API do
 * <b>ViaCEP</b>.
 * 
 *<a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 *<a href="https://viacep.com.br">ViaCEP</a>
 */

@FeignClient(name="viacep", url="https://viacep.com.br/ws")
public interface ViaCepService {
	
	//método que eu passo um cep na path e ele busca um json lá no viacep com todo o endereço. Ele vai converter pra o tipo Endereço que já está mapeado la no model
	//@RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
	//posso usar das duas formas, mas o GetMapping já diz que é o get na path
	@GetMapping("/{cep}/json/")
	Endereco consultarCep(@PathVariable("cep") String cep);

}
