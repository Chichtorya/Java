<%-- 
    Document   : Home
    Created on : Jan 30, 2023, 10:48:52 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="css/Home.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
  <link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css" rel="stylesheet" />
</head>

<body>
  <button class="btn">Save</button>
  <div class="bottom">
  </div>
  <nav>
    <div class="logo">
      <i class="bx bx-menu menu-icon"></i>
      <span class="logo-name">${sessionScope.name}</span>
    </div>
    <div class="sidebar">
      <div class="logo">
        <i class="bx bx-menu menu-icon"></i>
        <span class="logo-name">Menu</span>
      </div>

      <div class="sidebar-content">
        <ul class="lists">
          <li class="list">
            <a href="#" class="nav-link">
              <i class="bx bx-home-alt icon"></i>
              <span class="link">Home</span>
            </a>
          </li>
          <li class="list">
            <a href="/user" class="nav-link">
              <i class="bx bx-bar-chart-alt-2 icon"></i>
              <span class="link">Employee</span>
            </a>
          </li>
          <li class="list">
            <a href="#" class="nav-link">
              <i class="bx bx-bell icon"></i>
              <span class="link">Schedule</span>
            </a>
          </li>
          <li class="list">
            <a href="/patient" class="nav-link">
              <i class="bx bx-folder-open icon"></i>
              <span class="link">Patien Records</span>
            </a>
          </li>
        </ul>
        <div class="bottom-cotent">
          <li class="list">
            <a href="#" class="nav-link">
              <i class="bx bx-cog icon"></i>
              <span class="link">Settings</span>
            </a>
          </li>
          <li class="list">
            <a href="/login" class="nav-link">
              <i class="bx bx-log-out icon"></i>
              <span class="link">Logout</span>
            </a>
          </li>
        </div>
      </div>
    </div>
  </nav>
  <div class="toast">
    <div class="toast-content">
      <i class="fas fa-solid fa-check check"></i>

      <div class="message">
        <span class="text text-1">Success</span>
        <span class="text text-2">Your changes has been saved</span>
      </div>
    </div>
    <i class="fa-solid fa-xmark close"></i>

    <div class="progress"></div>
  </div>
  <section class="overlay"></section>
  <script>
    const navBar = document.querySelector("nav"),
      menuBtns = document.querySelectorAll(".menu-icon"),
      overlay = document.querySelector(".overlay");

    menuBtns.forEach((menuBtn) => {
      menuBtn.addEventListener("click", () => {
        navBar.classList.toggle("open");
      });
    });

    overlay.addEventListener("click", () => {
      navBar.classList.remove("open");
    });

    const button = document.querySelector(".btn"),
      toast = document.querySelector(".toast");
    closeIcon = document.querySelector(".close"),
      progress = document.querySelector(".progress");

    let timer1, timer2;

    button.addEventListener("click", () => {
      toast.classList.add("active");
      progress.classList.add("active");
      button.disabled = true;
      timer1 = setTimeout(() => {
        toast.classList.remove("active");
      }, 5000); //1s = 1000 milliseconds

      timer2 = setTimeout(() => {
        button.disabled = false;
        progress.classList.remove("active");
      }, 5300);
    });

    closeIcon.addEventListener("click", () => {
      toast.classList.remove("active");
      setTimeout(() => {
        progress.classList.remove("active");
        button.disabled = false;
      }, 300);

      clearTimeout(timer1);
      clearTimeout(timer2);
    });
  </script>
</body>

</html>
