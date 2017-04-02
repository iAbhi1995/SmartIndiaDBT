package com.smartindia.hackathon.biotechnology.Updates.Model;


import com.smartindia.hackathon.biotechnology.Updates.UpdateCallback;

public interface UpdateProvider {
    void requestUpdate(UpdateCallback updateCallback);
}
