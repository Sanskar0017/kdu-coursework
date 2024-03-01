function loginUser(event) {
  event.preventDefault();
  const username = document.getElementById("login_username").value;
  const password = document.getElementById("login_password").value;

  if (username.trim() === "" || password.trim() === "") {
    alert("Enter username and password, missing!");
    return;
  }

  console.log(username);

  fetch("http://localhost:3000/api/user/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ username, password }),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json();
    })
    .then((data) => {
      if (data) {
        console.log("Successfully logged In");
        window.location.href = `home.html?user=${JSON.stringify(data.user)}`;
      } else {
        alert("Invalid username or password");
      }
    })
    .catch((error) => {
      console.error("Error:", error);
      alert("An error occurred. Please try again later.");
    });
}
