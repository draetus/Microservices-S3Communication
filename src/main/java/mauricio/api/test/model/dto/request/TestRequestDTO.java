package mauricio.api.test.model.dto.request;

public class TestRequestDTO {
	
	private String base64Image;

	public TestRequestDTO() {
		super();
	}

	public TestRequestDTO(String base64Image) {
		super();
		this.base64Image = base64Image;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
}
