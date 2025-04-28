/* ANOT COD
 * 
 * 'collection' - É COMO SE FOSSE UMA TABELA DENTRO DO MONGODB
 *      ONDE 'urls' SERIA O NOME DA TABELA
 * 
 * */

package entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urls")
public class UrlEntitys {
	
	@Id
	private String id; // SEQUÊNCIA DE CARACTERES FINAL
	
	private String fullUrl; // URL ORIGINAL
	
	@Indexed(expireAfterSeconds = 0)
	private LocalDateTime expiresAt;

	
	public UrlEntitys() {

	}

	public UrlEntitys(String id, String fullUrl, LocalDateTime expiresAt) {
		this.id = id;
		this.fullUrl = fullUrl;
		this.expiresAt = expiresAt;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFullUrl() {
		return fullUrl;
	}


	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}


	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}


	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}
	
	
	
	
	
	
}
