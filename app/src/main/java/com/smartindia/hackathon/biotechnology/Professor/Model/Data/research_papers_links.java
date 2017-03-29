package com.smartindia.hackathon.biotechnology.Professor.Model.Data;

/**
 * Created by ayush on 27-03-2017.
 */

public class research_papers_links {

    private String research_title;
    private String download_link;

    public research_papers_links(String research_title,String download_link) {
        this.research_title = research_title;
        this.download_link = download_link;
    }

    public String getResearch_title() {
        return research_title;
    }

    public void setResearch_title(String research_title)
    {
        this.research_title = research_title;
    }
    public String getDownload_link() {
        return download_link;
    }

    public void setDownload_link(String download_link) {
        this.download_link = download_link;
    }
}
