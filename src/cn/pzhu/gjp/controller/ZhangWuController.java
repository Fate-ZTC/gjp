package cn.pzhu.gjp.controller;

import java.util.List;

import cn.pzhu.gjp.domain.ZhangWu;
import cn.pzhu.gjp.service.ZhangWuService;
/*
 * ���Ʋ�
 * ������ͼ�����ݣ����ݴ��ݸ�service��
 * ��Աλ�ã�����service����
 */
public class ZhangWuController {
	private ZhangWuService service=new ZhangWuService();
	/*
	 * ����һ��������ʵ��ɾ��������
	 * ��ͼ����ã�����int��������
	 * ����Service�㷽��
	 */
	public void deleteZhangWu(int zwid){
		service.deleteZhangWu(zwid);
	}
	/*
	 * ����һ��������ʵ���޸�������
	 * ����ͼ����ã����ݲ�����Ҳ��ZhangWu����
	 * ����service��ķ���������ZhangWu����
	 */
	public void editZhangWu(ZhangWu zw){
		service.editZhangWu(zw);
	}
	/*
	 * ����һ��������ʵ���������ӹ���
	 * ����ͼ����ã����ݲ��������ݹ����Ĳ���������5�����ݣ����ݵ���һ��ZhangWu����
	 * ��������service�㷽�������ݶ��󣬻�ȡ�����(��ӳɹ�������)
	 */
	public void addZhangWu(ZhangWu zw){
		service.addZhangWu(zw);
	}
	/*
	 * ���巽����ʵ��������ѯ
	 * �����ɿ��Ʋ���ã��������������ַ���
	 * ����Dao��ķ������������������ַ���
	 * ��ȡ��ѯ�����
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return service.select(startDate,endDate);
	}
	/*
	 * ���Ʋ��ඨ�巽����ʵ�ֲ�ѯ�������ݵĹ���
	 * ��������ͼ����ã���������Service��
	 */
	public List<ZhangWu> selectAll(){
		return service.selectAll();
		
	}
}
