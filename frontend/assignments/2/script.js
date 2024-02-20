const inputPostValue = document.getElementsByClassName("post-input");
const addTweetpost = document.getElementsByClassName("add-tweet-post");
const showMobileMenu = document.getElementsByClassName(".N-button-top");
const mobDisplay = document.getElementsByClassName("mob-display");
const mobilePost = document.getElementsByClassName("mob-post-icon");
const mobileTweet = document.getElementsByClassName("mobile-tweet");
let likeCount = 0;

function incrementLike() {
  return likeCount + 1;
}

function postTweet() {
  let postInput = inputPostValue[0].value;

  let addPost = `
    <div id = "tweet-box-second-p">
    <div class="box-div-one">
        <img src = "./Profile/profile pic.png" alt="profile-logo" id = "img-N-logo">
    </div>
    <div class="box-div-two">
        <div id = "box-div-f">
            <div class = "post-user-f">
                <div class = "post-user-divide">
                    <div class = "user-identity" id = "post-user-name">Nitesh Gupta &nbsp;</div>
                <div class = "user-identity" id = "post-user-id">@nit_hck . 34s &nbsp;</div>
                </div>
                <div class = "post-user-divide">
                    <div id = "post-three-dots">
                        <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-1xvli5t r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1nao33i"><g><path d="M3 12c0-1.1.9-2 2-2s2 .9 2 2-.9 2-2 2-2-.9-2-2zm9 2c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm7 0c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2z"></path></g></svg>
                    </div>
                </div>
                
                
            </div>
        </div>
        <div id = "box-div-s">
            <p>${postInput}</p>
        </div>
        <div id = "box-div-t">
            <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M1.751 10c0-4.42 3.584-8 8.005-8h4.366c4.49 0 8.129 3.64 8.129 8.13 0 2.96-1.607 5.68-4.196 7.11l-8.054 4.46v-3.69h-.067c-4.49.1-8.183-3.51-8.183-8.01zm8.005-6c-3.317 0-6.005 2.69-6.005 6 0 3.37 2.77 6.08 6.138 6.01l.351-.01h1.761v2.3l5.087-2.81c1.951-1.08 3.163-3.13 3.163-5.36 0-3.39-2.744-6.13-6.129-6.13H9.756z"></path></g></svg>
            <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M4.5 3.88l4.432 4.14-1.364 1.46L5.5 7.55V16c0 1.1.896 2 2 2H13v2H7.5c-2.209 0-4-1.79-4-4V7.55L1.432 9.48.068 8.02 4.5 3.88zM16.5 6H11V4h5.5c2.209 0 4 1.79 4 4v8.45l2.068-1.93 1.364 1.46-4.432 4.14-4.432-4.14 1.364-1.46 2.068 1.93V8c0-1.1-.896-2-2-2z"></path></g></svg>
            <svg onclick="likeButton()" id = "like-post" viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M16.697 5.5c-1.222-.06-2.679.51-3.89 2.16l-.805 1.09-.806-1.09C9.984 6.01 8.526 5.44 7.304 5.5c-1.243.07-2.349.78-2.91 1.91-.552 1.12-.633 2.78.479 4.82 1.074 1.97 3.257 4.27 7.129 6.61 3.87-2.34 6.052-4.64 7.126-6.61 1.111-2.04 1.03-3.7.477-4.82-.561-1.13-1.666-1.84-2.908-1.91zm4.187 7.69c-1.351 2.48-4.001 5.12-8.379 7.67l-.503.3-.504-.3c-4.379-2.55-7.029-5.19-8.382-7.67-1.36-2.5-1.41-4.86-.514-6.67.887-1.79 2.647-2.91 4.601-3.01 1.651-.09 3.368.56 4.798 2.01 1.429-1.45 3.146-2.1 4.796-2.01 1.954.1 3.714 1.22 4.601 3.01.896 1.81.846 4.17-.514 6.67z"></path></g></svg>
            <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M8.75 21V3h2v18h-2zM18 21V8.5h2V21h-2zM4 21l.004-10h2L6 21H4zm9.248 0v-7h2v7h-2z"></path></g></svg>
            <div id = "last-two">
                <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M4 4.5C4 3.12 5.119 2 6.5 2h11C18.881 2 20 3.12 20 4.5v18.44l-8-5.71-8 5.71V4.5zM6.5 4c-.276 0-.5.22-.5.5v14.56l6-4.29 6 4.29V4.5c0-.28-.224-.5-.5-.5h-11z"></path></g></svg>
                <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M12 2.59l5.7 5.7-1.41 1.42L13 6.41V16h-2V6.41l-3.3 3.3-1.41-1.42L12 2.59zM21 15l-.02 3.51c0 1.38-1.12 2.49-2.5 2.49H5.5C4.11 21 3 19.88 3 18.5V15h2v3.5c0 .28.22.5.5.5h12.98c.28 0 .5-.22.5-.5L19 15h2z"></path></g></svg>
            </div>
        </div>
    </div>
</div>
    `;

  addTweetpost[0].innerHTML += addPost;
  inputPostValue[0].value = "";
}

function likeButton() {
  console.log("liked button");
  let likePost = document.getElementById("like-post");
  if (likePost && inputPostValue.length > 0) {
    likePost.style.fill = likePost.style.fill == "grey" ? "red" : "grey";
  }
}

function postLikeButton() {
  let likePost = document.getElementById("icons-like");
  if (likePost && inputPostValue.length > 0) {
    likePost.style.fill = likePost.style.fill == "grey" ? "red" : "grey";
  }
}

function menu() {
  if (mobDisplay[0].style.display === "flex") {
    mobDisplay[0].style.display = "none";
  } else {
    mobDisplay[0].style.display = "flex";
  }
}

function postMobile() {
  console.log("logging new post");
  let navSection = document.querySelector(".nav-section");
  let postBtn = document.querySelector(".postbtn");
  let postScreenMob = document.querySelector(".post-screen-mob");
  navSection.style.display = "none";
  postBtn.style.display = "flex";

  console.log(postBtn.style.display);

  postScreenMob.insertAdjacentHTML("beforeend", postBtn.innerHTML);
  console.log(postScreenMob.innerHTML);
}

function messageUser() {
  console.log("message is found");
  document.getElementsByClassName("tweet-box-section")[0].style.display =
    "none";
  document.getElementsByClassName("chat-container")[0].style.display = "flex";
}

document.addEventListener("DOMContentLoaded", () => {
  const activeUsersDiv = document.querySelector(".display-all-active-users");

  fetch("/api/active-users")
    .then((response) => response.json())
    .then((activeUsers) => {
      activeUsers.forEach((user) => {
        const userDiv = document.createElement("div");
        userDiv.textContent = user;
        activeUsersDiv.appendChild(userDiv);

        userDiv.addEventListener("click", () => {
          const selectedUser = userDiv.textContent;
          fetchChatMessages(selectedUser);
        });
      });
    })
    .catch((error) => {
      console.error("Error fetching active users:", error);
    });

  function fetchChatMessages(selectedUser) {
    fetch(`/api/chat-messages?user=${selectedUser}`)
      .then((response) => response.json())
      .then((chatMessages) => {
        displayChatMessages(selectedUser, chatMessages);
      })
      .catch((error) => {
        console.error("Error fetching chat messages:", error);
      });
  }

  function displayChatMessages(selectedUser, chatMessages) {
    const chatMessagesDiv = document.querySelector(".chat-messages");
    chatMessagesDiv.innerHTML = "";

    chatMessages.forEach((message) => {
      const messageDiv = document.createElement("div");
      messageDiv.textContent = message;
      chatMessagesDiv.appendChild(messageDiv);
    });

    document.getElementById("chat-box-current-user-name").textContent =
      selectedUser;
  }

  document.getElementById("send-msg-btn").addEventListener("click", () => {
    const messageInput = document.getElementById("messageInput");
    const message = messageInput.value.trim();
    const selectedUser = document.getElementById(
      "chat-box-current-user-name"
    ).textContent;

    if (message !== "") {
      sendMessageToServer(selectedUser, message);
      displaySentMessage(message);
      messageInput.value = "";
    }
  });

  function sendMessageToServer(selectedUser, message) {
    console.log(`Sending message to ${selectedUser}: ${message}`);
  }

  function displaySentMessage(message) {
    const chatMessagesDiv = document.querySelector(".chat-messages");
    const messageDiv = document.createElement("div");
    messageDiv.textContent = message;
    chatMessagesDiv.appendChild(messageDiv);
  }
});

// adding post

let pageNumber = 1;
const pageSize = 5;

async function fetchPosts() {
  try {
    const response = await fetch(
      `http://localhost:3000/api/posts?pageNumber=${pageNumber}&pageSize=${pageSize}`
    );
    if (response.ok) {
      const posts = await response.json();
      console.log("Fetched posts:", posts);

      if (posts.length > 0) {
        posts.forEach((post) => {
          postNewTweet(post.postInput);
        });
        pageNumber++;
        maxLoadCount--;
      }
    } else {
      console.error("Error fetching posts:", response.status);
    }
  } catch (error) {
    console.error("Error fetching posts:", error);
  }
}

function isScrolledToBottom() {
  const scrollTop =
    document.documentElement.scrollTop || document.body.scrollTop;
  const windowHeight = window.innerHeight;
  const documentHeight = Math.max(
    document.body.scrollHeight,
    document.documentElement.scrollHeight,
    document.body.offsetHeight,
    document.documentElement.offsetHeight,
    document.body.clientHeight,
    document.documentElement.clientHeight
  );

  return scrollTop + windowHeight >= documentHeight - 100;
}

function postNewTweet(post) {
  let addPost = `
    <div id = "tweet-box-second-p">
    <div class="box-div-one">
        <img src = "./profile pic.png" alt="profile-logo" id = "img-N-logo">
    </div>
    <div class="box-div-two">
        <div id = "box-div-f">
            <div class = "post-user-f">
                <div class = "post-user-divide">
                    <div class = "user-identity" id = "post-user-name">Nitesh Gupta &nbsp;</div>
                <div class = "user-identity" id = "post-user-id">@nit_hck . 34s &nbsp;</div>
                </div>
                <div class = "post-user-divide">
                    <div id = "post-three-dots">
                        <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-1xvli5t r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1nao33i"><g><path d="M3 12c0-1.1.9-2 2-2s2 .9 2 2-.9 2-2 2-2-.9-2-2zm9 2c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2zm7 0c1.1 0 2-.9 2-2s-.9-2-2-2-2 .9-2 2 .9 2 2 2z"></path></g></svg>
                    </div>
                </div>


            </div>
        </div>
        <div id = "box-div-s">
            <p>${post}</p>
        </div>
        <div id = "box-div-t">
            <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M1.751 10c0-4.42 3.584-8 8.005-8h4.366c4.49 0 8.129 3.64 8.129 8.13 0 2.96-1.607 5.68-4.196 7.11l-8.054 4.46v-3.69h-.067c-4.49.1-8.183-3.51-8.183-8.01zm8.005-6c-3.317 0-6.005 2.69-6.005 6 0 3.37 2.77 6.08 6.138 6.01l.351-.01h1.761v2.3l5.087-2.81c1.951-1.08 3.163-3.13 3.163-5.36 0-3.39-2.744-6.13-6.129-6.13H9.756z"></path></g></svg>
            <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M4.5 3.88l4.432 4.14-1.364 1.46L5.5 7.55V16c0 1.1.896 2 2 2H13v2H7.5c-2.209 0-4-1.79-4-4V7.55L1.432 9.48.068 8.02 4.5 3.88zM16.5 6H11V4h5.5c2.209 0 4 1.79 4 4v8.45l2.068-1.93 1.364 1.46-4.432 4.14-4.432-4.14 1.364-1.46 2.068 1.93V8c0-1.1-.896-2-2-2z"></path></g></svg>
            <svg onclick="likeButton()" id = "like-post" viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M16.697 5.5c-1.222-.06-2.679.51-3.89 2.16l-.805 1.09-.806-1.09C9.984 6.01 8.526 5.44 7.304 5.5c-1.243.07-2.349.78-2.91 1.91-.552 1.12-.633 2.78.479 4.82 1.074 1.97 3.257 4.27 7.129 6.61 3.87-2.34 6.052-4.64 7.126-6.61 1.111-2.04 1.03-3.7.477-4.82-.561-1.13-1.666-1.84-2.908-1.91zm4.187 7.69c-1.351 2.48-4.001 5.12-8.379 7.67l-.503.3-.504-.3c-4.379-2.55-7.029-5.19-8.382-7.67-1.36-2.5-1.41-4.86-.514-6.67.887-1.79 2.647-2.91 4.601-3.01 1.651-.09 3.368.56 4.798 2.01 1.429-1.45 3.146-2.1 4.796-2.01 1.954.1 3.714 1.22 4.601 3.01.896 1.81.846 4.17-.514 6.67z"></path></g></svg>
            <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M8.75 21V3h2v18h-2zM18 21V8.5h2V21h-2zM4 21l.004-10h2L6 21H4zm9.248 0v-7h2v7h-2z"></path></g></svg>
            <div id = "last-two">
                <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M4 4.5C4 3.12 5.119 2 6.5 2h11C18.881 2 20 3.12 20 4.5v18.44l-8-5.71-8 5.71V4.5zM6.5 4c-.276 0-.5.22-.5.5v14.56l6-4.29 6 4.29V4.5c0-.28-.224-.5-.5-.5h-11z"></path></g></svg>
                <svg viewBox="0 0 24 24" aria-hidden="true" class="r-4qtqp9 r-yyyyoo r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-1xvli5t r-1hdv0qi"><g><path d="M12 2.59l5.7 5.7-1.41 1.42L13 6.41V16h-2V6.41l-3.3 3.3-1.41-1.42L12 2.59zM21 15l-.02 3.51c0 1.38-1.12 2.49-2.5 2.49H5.5C4.11 21 3 19.88 3 18.5V15h2v3.5c0 .28.22.5.5.5h12.98c.28 0 .5-.22.5-.5L19 15h2z"></path></g></svg>
            </div>
        </div>
    </div>
</div>
    `;
  console.log("adding new post thriving");
  addTweetpost[0].innerHTML += addPost;
  inputPostValue[0].value = "";
}

window.addEventListener("scroll", async () => {
  if (isScrolledToBottom()) {
    pageNumber++;
    const newPosts = await fetchPosts();
    newPosts.forEach((post) => {
      postNewTweet(post);
    });
  }
});

window.addEventListener("load", async () => {
  const initialPosts = await fetchPosts();
  initialPosts.forEach((post) => {
    postNewTweet(post);
  });
});
