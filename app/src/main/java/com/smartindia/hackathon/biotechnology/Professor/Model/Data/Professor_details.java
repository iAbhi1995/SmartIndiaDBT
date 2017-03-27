package com.smartindia.hackathon.biotechnology.Professor.Model.Data;

import java.util.List;

/**
 * Created by ayush on 27-03-2017.
 */
public class Professor_details {

    private int prof_id;
    private String image;
    private String name;
    private String designation;
    private String phone;
    private String email_id;
    private String area_interest;
    private String affiliation;
    private String edu_degree;
    private String edu_institute;
    private String research_papers;
    private List<research_papers_links> research_papers_links;



    public Professor_details(int prof_id,String image,String name, String designation,String phone,String email_id,String area_interest,
                 String affiliation, String edu_degree, String edu_institute, String research_papers,List<research_papers_links> research_papers_links) {
        this.prof_id = prof_id;
        this.image = image;
        this.name = name;
        this.designation = designation;
        this.phone = phone;
        this.email_id = email_id;
        this.area_interest = area_interest;
        this.affiliation = affiliation;
        this.edu_degree = edu_degree;
        this.edu_institute = edu_institute;
        this.research_papers = research_papers;
        this.research_papers_links = research_papers_links;
    }

    public  int getProf_id(){
        return  getProf_id();
    }
    public void setProf_id(int prof_id){
        this.prof_id=prof_id;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail_id() {
        return email_id;
    }
    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getArea_interest() {
        return area_interest;
    }

    public void setArea_interest(String area_interest) {
        this.area_interest = area_interest;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getEdu_degree() {
        return edu_degree;
    }
    public void setEdu_degree(String edu_degree) {
        this.edu_degree = edu_degree;
    }

    public String getEdu_institute() {
        return edu_institute;
    }

    public void setEdu_institute(String edu_institute) {
        this.edu_institute = edu_institute;
    }

    public String getResearch_papers() {
        return research_papers;
    }

    public void setResearch_papers(String research_papers) {
        this.research_papers = research_papers;
    }

    public List<research_papers_links> getResearch_papers_links() {
        return research_papers_links;
    }

    public void setResearch_papers_links(List<research_papers_links> research_papers_links) {
        this.research_papers_links = research_papers_links;
    }
}