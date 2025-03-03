    'use strict';
    const usernamePage = document.querySelector('#username-page');
    const chatPage = document.querySelector('#chat-page');
    const usernameForm = document.querySelector('#usernameForm');
    const messageForm = document.querySelector('#messageForm');
    const messageInput = document.querySelector('#message');
    const connectingElement = document.querySelector('.connecting');
    const chatArea = document.querySelector('#chat-messages');
    const logout = document.querySelector('#logout');

    let stompClient = null;
    let nickname = null;
    let fullname = null;
    let selectedUserId = null;

    function connect(event) {
        nickname  = document.querySelector('#nickname').value.trim()
        fullname  = document.querySelector('#fullname').value.trim()

        if(nickname&&fullname){
            usernamePage.classList.add('hidden');
            chatPage.classList.add('hidden');


            const socket = new SockJS('/ws');
            stompClient = Stomp.over(socket);

            stompClient.connect({}, onConnected, onError);



        }

        event.preventDefault();


    }




    usernameForm.addEventListener('submit', connect, true); // step 1
    messageForm.addEventListener('submit', sendMessage, true);
    logout.addEventListener('click', onLogout, true);
    window.onbeforeunload = () => onLogout();