import com.mq.utils.JSONUtil;

public class Test {

	public static void main(String[] args) {
		PayMessageVo payMessageVo=new PayMessageVo();
		try {
			String beanToJson = JSONUtil.beanToJson(payMessageVo);
			System.out.println(beanToJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}