package cn.pzhu.gjp.view;

import cn.pzhu.gjp.controller.ZhangWuController;
import cn.pzhu.gjp.domain.ZhangWu;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

/*
 * ��ͼ�㣬�û������Ͳ����Ľ���
 * ���ݴ��ݸ�controller��ʵ��
 * ��Աλ�ã�����controller����
 */
public class MainView {
	private ZhangWuController controller=new ZhangWuController();
	/*
	 * ʵ�ֽ���Ч��
	 * ��ɼ�������
	 */
	@Test
	public void run(){
		//����Scanner����󣬷�����������
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("---------------�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
			//�����û��Ĳ˵�ѡ��
			int choose=sc.nextInt();
			//��ѡ��Ĳ˵��жϣ����ò�ͬ�Ĺ���
			switch(choose){
				case 1:
//					�������
					addZhangWu();
					break;
				case 2:
//					�༭����
					editZhangWu();
					break;
				case 3:
//					ɾ������
					deleteZhangWu();
					break;
				case 4:
//					��ѯ����
					selectZhangWu();
					break;
				case 5:
					System.exit(0);
					break;
				
			}
		}
	}
	/*
	 * ����һ��������ʵ�������ɾ��
	 * ʵ��˼�룺
	 * 		�����û����룬����һ����������
	 * 		���ÿ��Ʋ㷽��������һ������
	 */
	public void deleteZhangWu(){
		//���ò�ѯ�������ݵĹ��ܣ���ʾ����
		//�����������ݣ�����ѡ��һ�����ɾ��
		selectAll();
		System.out.println("��ѡ�����ɾ�����ܣ��������");
		int zwid=new Scanner(System.in).nextInt();
		//���ÿ��Ʋ㷽������������id����
		controller.deleteZhangWu(zwid);
		System.out.println("ɾ������ɹ�");
	}
	/*
	 * ����һ��������ʵ�ֶ�����ı༭����
	 * ʵ��˼�룺
	 * 		�����û�����
	 * 		���ݵ���Ϣ��ת��ΪZhangWu����
	 *		 ���ÿ��Ʋ�ķ���������ZhangWu����ʵ�ֱ༭
	 */
	public void editZhangWu(){
		//���ò�ѯ�����������ݵĹ��ܣ���ʾ����
		//�����������ݣ�����ѡ��һ������޸�
		selectAll();
		System.out.println("ѡ������޸����ݵĹ��ܣ��������޸ĵ����ݣ�");
		Scanner sc=new Scanner(System.in);
		//�����û�������
		System.out.println("����ID��");
		int zwid=sc.nextInt();
		System.out.println("����������ƣ�");
		String flname=sc.next();
		System.out.println("�����");
		double money=sc.nextDouble();
		System.out.println("�����˻���");
		String zhanghu=sc.next();
		System.out.println("�������ڣ���ʽxxxx-xx-xx��");
		String createtime=sc.next();
		System.out.println("�������������");
		String description=sc.next();
		//��װΪ����
		//�����ID�������װΪ����
		ZhangWu zw=new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		//����controller��ķ����������޸�
		controller.editZhangWu(zw);
		System.out.println("�����޸ĳɹ�");
	}
	/*
	 * ����һ������addZhangWu
	 * �������ķ������û��ڽ���ѡ��1�ǵ���
	 * ʵ��˼�룺
	 * 		���ܼ�������
	 */
	public void addZhangWu(){
		System.out.println("��ѡ������������Ĺ��ܣ�������һ�����ݣ�");
		Scanner sc=new Scanner(System.in);
		System.out.println("����������ƣ�");
		String flname=sc.next();
		System.out.println("�����");
		double money=sc.nextDouble();
		System.out.println("�����˻���");
		String zhanghu=sc.next();
		System.out.println("�������ڣ���ʽxxxx-xx-xx��");
		String createtime=sc.next();
		System.out.println("�������������");
		String description=sc.next();
		//�����ܵ����ݣ����ݸ�controller�㣬���ݲ���
		//���û���������ݷ�װΪһ��zhangwu����
		ZhangWu zw=new ZhangWu(0,flname,money,zhanghu,createtime,description);
		controller.addZhangWu(zw);
		System.out.println("�������ɹ���");
		}
	/*
	 * ����һ������selectZhangWu()
	 * ��ʾ��ѯ�ķ�ʽ1���в�ѯ 2������ѯ
	 * �����û���ѡ��
	 */
	public void selectZhangWu(){
		System.out.println("1:��ѯ����   2��������ѯ");
		Scanner sc=new Scanner(System.in);
		int selectChooser=sc.nextInt();
		//�ж��û���ѡ�񣬵��ò�ͬ�Ĺ���
		switch(selectChooser){
		case 1:
			//��ѯ���еķ���
			selectAll();
			break;
		case 2:
			select();
			//������ѯ�ķ���
			break;
		}
	}
	/*
	 * ���巽����ʵ�ֲ�ѯ���е���������
	 */
	public void selectAll(){
		//���ÿ��Ʋ��еķ�������ѯ������������
		List<ZhangWu> list=controller.selectAll();
		if(list.size()!=0)
			print(list);
		else
			System.out.println("û�в�ѯ������");
	}
	//����������ݵķ���������List���ϣ���������,������
	private void print(List<ZhangWu> list) {
		//�����ͷ
		System.out.println("ID\t\t���\t\t�˻�\t\t���\t\tʱ��\t\t\t\t˵��");
		//��������
		for(ZhangWu zw:list){
			System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getZhanghu()+"\t\t"+
		zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t\t\t"+zw.getDescription());
		}
	}
	/*
	 * ���巽����ʵ��������ѯ
	 * �û����������ڣ���ʼ���ںͽ�������
	 * ���ݵ�controller�ķ����������������ڲ���
	 * ��ȡcontroller��ѯ�Ľ��������ӡ����
	 */
	public void select(){
		System.out.println("��ѡ�����������ѯ���������ڸ�ʽxxxx-xx-xx");
		Scanner sc=new Scanner(System.in);
		System.out.print("�����뿪ʼ���ڣ�");
		String startDate=sc.nextLine();
		System.out.print("������������ڣ�");
		String endDate=sc.nextLine();
		//����controller��ķ������������ڣ���ý����
		List<ZhangWu> list=controller.select(startDate, endDate);
		if(list.size()!=0)
			print(list);
		else
			System.out.println("û�в�ѯ������");
	}
}
