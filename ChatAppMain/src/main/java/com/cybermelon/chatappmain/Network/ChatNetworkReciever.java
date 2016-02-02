package com.cybermelon.chatappmain.Network;

public interface ChatNetworkReciever {
    public void RecievedUpdateOnMessageStatus(String sNewStatus);
    public void RecievedMessagesList();
    public void RecievedMessage();
    public void RecievedContactDisplayPic();
    public void RecievedContactStatus();
    public void RecievedStatusOnDisplayPicUpdate();
    public void RecievedStatusStatusUpdated();
    public void SignInSuccess();
    public void SignInFailure();
    public void RecievedNoDataWarning();
    public void RecieveddDataHasReturnedNotification();
    public void RecievedListValidContacts();
}
