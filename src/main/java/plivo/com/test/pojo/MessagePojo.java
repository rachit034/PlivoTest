package plivo.com.test.pojo;


	import com.fasterxml.jackson.annotation.JsonInclude;
	import com.fasterxml.jackson.annotation.JsonProperty;
	import com.fasterxml.jackson.annotation.JsonPropertyOrder;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"src",
	"dst",
	"text"
	})
	
	public class MessagePojo {
	@JsonProperty("src")
	private String src;
	@JsonProperty("dst")
	private String dst;
	@JsonProperty("text")
	private String text;

	@JsonProperty("src")
	public String getSrc() {
	return src;
	}

	@JsonProperty("src")
	public void setSrc(String src) {
	this.src = src;
	}

	@JsonProperty("dst")
	public String getDst() {
	return dst;
	}

	@JsonProperty("dst")
	public void setDst(String dst) {
	this.dst = dst;
	}

	@JsonProperty("text")
	public String getText() {
	return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
	this.text = text;
	}

	}


