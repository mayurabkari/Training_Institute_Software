package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Admission;
import dto.Branches;
import dto.Courses;
import dto.Student;
import dto.Trainer;
import dto.TrainingInstitute;

public class Driver {

		public static void main(String[] args) {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("mayur");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			
			TrainingInstitute tr=new TrainingInstitute();
			tr.setId(1);
			tr.setName("jspider");
			
			Branches b=new Branches();
			b.setId(1);
			b.setNameofBranch("Deccan");
		
			Branches b1=new Branches();
			b1.setId(2);
			b1.setNameofBranch("Wakad");
			
			List<Branches> branches=new ArrayList<Branches>();
			branches.add(b);
			branches.add(b1);
			
			tr.setBranches(branches);
			
			Trainer tr1=new Trainer();
			tr1.setId(1);
			tr1.setNameOfTrainer("Vara prasad Sir");
			tr1.setSubject("Advance Java");
			tr1.setBr(b);
			
			Trainer tr2=new Trainer();
			tr2.setId(2);
			tr2.setNameOfTrainer("Tejus Sir");
			tr2.setSubject("Core java");
			tr2.setBr(b1);
			
			Admission a=new Admission();
			a.setIdno(101);
			a.setEmail("mayurabkari89@gmail.com");
			a.setBrr(b);
			
			Admission a1=new Admission();
			a1.setIdno(102);
			a1.setEmail("vaibhav@gmail.com");
			a1.setBrr(b);
			
			Admission a2=new Admission();
			a2.setIdno(103);
			a2.setEmail("onkar@gmail.com");
			a2.setBrr(b1);
			
			Admission a3=new Admission();
			a3.setIdno(104);
			a3.setEmail("ramchandra@gmail.com");
			a3.setBrr(b1);
			
			Student s=new Student();
			s.setId(101);
			s.setName("Mayur");
			s.setYop(2022);
			s.setStream("Mechanical Engineering");
			s.setAdd1(a);
			
			Student s1=new Student();
			s1.setId(102);
			s1.setName("Onkar");
			s1.setYop(2022);
			s1.setStream("Mechanical Engineering");
			s1.setAdd1(a2);
			
			Student s2=new Student();
			s2.setId(103);
			s2.setName("Ramchandra");
			s2.setYop(2022);
			s2.setStream("ENTC");
			s2.setAdd1(a3);
			
			Student s3=new Student();
			s3.setId(104);
			s3.setName("Vaibhav");
			s3.setYop(2022);
			s3.setStream("Mechanical Engineering");
			s3.setAdd1(a1);
			
		
			Courses c=new Courses();
			c.setCid(101);
			c.setCourseName("Core Java");
			c.setBran(b);
			
			Courses c1=new Courses();
			c1.setCid(102);
			c1.setCourseName("J2EE");
			c1.setBran(b);
			
			Courses c2=new Courses();
			c2.setCid(103);
			c2.setCourseName("FrameWorks");
			c2.setBran(b);
			
			Courses c4=new Courses();
			c4.setCid(104);
			c4.setCourseName("Manual Testing");
			c4.setBran(b1);
			
			Courses c5=new Courses();
			c5.setCid(105);
			c5.setCourseName("Selenium");
			c5.setBran(b1);
			
			Courses c6=new Courses();
			c6.setCid(106);
			c6.setCourseName("Automation Testing");
			c6.setBran(b1);
			
			List<Student> studd=new ArrayList<Student>();
			studd.add(s3);
			studd.add(s);
			c.setStud(studd);
		    c1.setStud(studd);
		    c2.setStud(studd);
			
			List<Student> studd1=new ArrayList<Student>();
			studd1.add(s1);
			studd1.add(s2);
			c4.setStud(studd1);
			c5.setStud(studd1);
			c6.setStud(studd1);
			
			
			et.begin();
			em.persist(tr);
			em.persist(b);
			em.persist(b1);
			em.persist(tr1);
			em.persist(tr2);
			em.persist(a);
			em.persist(a1);
			em.persist(a2);
			em.persist(a3);
			em.persist(s);
			em.persist(s1);
			em.persist(s2);
			em.persist(s3);
			em.persist(c);
			em.persist(c1);
			em.persist(c2);
			em.persist(c4);
			em.persist(c5);
			em.persist(c6);
			et.commit();
			
			TrainingInstitute tra=em.find(TrainingInstitute.class, 1);
			System.out.println("Name Of Training Institute is: "+tra.getName());
			int deccanstudentcount=0;
			int count=0;
			int wakadcount=0;
			for(int i=1;i<=2;i++) {
				Branches bran=em.find(Branches.class, i);
				if(bran!=null) {
					count++;
				}
			}
			System.out.println("Number of Branches of "+tra.getName()+" is: "+count);
			for(int i=101;i<=104;i++) {
				Admission addd=em.find(Admission.class, i);
				Branches brrr=addd.getBrr();
				if(brrr.getNameofBranch()=="Deccan") {
					deccanstudentcount++;
				}
				else {
					wakadcount++;
				}
			}
			System.out.println("No Of Deccan Branch Students is: "+deccanstudentcount);
			System.out.println("No of Wakad Branch Students is: "+wakadcount);
			int Dcount=0;
			int Wcount=0;
			for(int i=101;i<=106;i++) {
				Courses cour=em.find(Courses.class, i);
				Branches br=cour.getBran();
				if(br.getNameofBranch()=="Deccan") {
					System.out.println(br.getNameofBranch()+"="+cour.getCourseName());
					List<Student> student=cour.getStud();
	                
					for(Student studdd:student) {
						Admission ad=studdd.getAdd1();
						Branches brrrr=ad.getBrr();
						
						if(brrrr.getNameofBranch()=="Deccan") {
							System.out.println(studdd.getName());
							Dcount++;
						}
						
					}
				}
				else if(br.getNameofBranch()=="Wakad") {
					System.out.println(br.getNameofBranch()+"="+cour.getCourseName());
                     List<Student> student=cour.getStud();
	                
					for(Student studdd:student) {
						Admission ad=studdd.getAdd1();
						Branches brrrr=ad.getBrr();
						
						if(brrrr.getNameofBranch()=="Deccan") {
							System.out.println(studdd.getName());
							Dcount++;
						}
						else {
							System.out.println(studdd.getName());
							Wcount++;
						}
				}
			}
			
		}
	}
}

