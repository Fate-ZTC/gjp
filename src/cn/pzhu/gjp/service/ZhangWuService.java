package cn.pzhu.gjp.service;

import java.util.List;

import cn.pzhu.gjp.dao.ZhangWuDao;
import cn.pzhu.gjp.domain.ZhangWu;
/*
 * ҵ�����
 * ������һ�㣬���Ʋ������
 * �������㣬���׸�dao�㣬�������ݿ�
 * ����dao�е��࣬���Աλ�ã�����dao����
 */
public class ZhangWuService {
	private ZhangWuDao dao=new ZhangWuDao();
	/*
	 * ����һ��������ʵ��ɾ��������
	 * ���Ʋ���ã�����int��������
	 * ����dao�㷽��
	 */
	public void deleteZhangWu(int zwid){
		dao.deleteZhangWu(zwid);
	}
	/*
	 * ����һ��������ʵ���޸�������
	 * �ɿ��Ʋ���ã����ݲ�����Ҳ��ZhangWu����
	 * ����dao��ķ���������ZhangWu����
	 */
	public void editZhangWu(ZhangWu zw){
		dao.editZhangWu(zw);
	}
	/*
	 * ����һ��������ʵ���������ӹ���
	 * �ɿ��Ʋ���ã����ݲ��������ݹ����Ĳ���������5�����ݣ����ݵ���һ��ZhangWu����
	 * ��������dao�㷽�������ݶ��󣬻�ȡ�����(��ӳɹ�������)
	 */
	public void addZhangWu(ZhangWu zw){
		dao.addZhangWu(zw);
	}
	/*
	 * ���巽����ʵ��������ѯ
	 * �����ɿ��Ʋ���ã��������������ַ���
	 * ����Dao��ķ������������������ַ���
	 * ��ȡ��ѯ�����
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return dao.select(startDate,endDate);
	}
	/*
	 * ���巽����ʵ�ֲ�ѯ���е���������
	 * �˷������п��Ʋ���ã�ȥ����dao��ķ���
	 */
	public List<ZhangWu> selectAll(){
		return dao.selectAll();
	}
}
