<%-- 
    Document   : Home
    Created on : Jan 30, 2023, 10:48:52 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/favicon.png" type="">

  <title> G6 - Health Care </title>

  <!-- bootstrap core css -->
 
</head>

<body>
 
 <jsp:include page="header.jsp"></jsp:include>


  <!-- department section -->

  <section class="department_section layout_padding">
    <div class="department_container">
      <div class="container ">
        <div class="heading_container heading_center">
          <h2>
            Our Departments
          </h2>
          <p>
            Asperiores sunt consectetur impedit nulla molestiae delectus repellat laborum dolores doloremque accusantium
          </p>
        </div>
        <div class="row">
          <div class="col-md-3">
            <div class="box ">
              <div class="img-box">
                <img src="images/s1.png" alt="">
              </div>
              <div class="detail-box">
                <h5>
                  Cardiology
                </h5>
                <p>
                  fact that a reader will be distracted by the readable page when looking at its layout.
                </p>
              </div>
            </div>
          </div>
          <div class="col-md-3">
            <div class="box ">
              <div class="img-box">
                <img src="images/s2.png" alt="">
              </div>
              <div class="detail-box">
                <h5>
                  Diagnosis
                </h5>
                <p>
                  fact that a reader will be distracted by the readable page when looking at its layout.
                </p>
              </div>
            </div>
          </div>
          <div class="col-md-3">
            <div class="box ">
              <div class="img-box">
                <img src="images/s3.png" alt="">
              </div>
              <div class="detail-box">
                <h5>
                  Surgery
                </h5>
                <p>
                  fact that a reader will be distracted by the readable page when looking at its layout.
                </p>
              </div>
            </div>
          </div>
          <div class="col-md-3">
            <div class="box ">
              <div class="img-box">
                <img src="images/s4.png" alt="">
              </div>
              <div class="detail-box">
                <h5>
                  First Aid
                </h5>
                <p>
                  fact that a reader will be distracted by the readable page when looking at its layout.
                </p>
              </div>
            </div>
          </div>    
        </div>
        <div class="btn-box">
         
        </div>
      </div>
    </div>
  </section>

  <!-- end department section -->

  <!-- about section -->

  <section class="about_section layout_margin-bottom">
    <div class="container  ">
      <div class="row">
        <div class="col-md-6 ">
          <div class="img-box">
            <img src="images/about-img.jpg" alt="">
          </div>
        </div>
        <div class="col-md-6">
          <div class="detail-box">
            <div class="heading_container">
              <h2>
                About <span>Us</span>
              </h2>
            </div>
            <p>
              There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration
              in some form, by injected humour, or randomised words which don't look even slightly believable. If you
              are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in
              the middle of text. All
            </p>
            <a href="">
              Read More
            </a>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- end about section -->

  <!-- doctor section -->

  <section class="doctor_section layout_padding">
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
          Our Doctors
        </h2>
        <p class="col-md-10 mx-auto px-0">
          Incilint sapiente illo quo praesentium officiis laudantium nostrum, ad adipisci cupiditate sit, quisquam aliquid. Officiis laudantium fuga ad voluptas aspernatur error fugiat quos facilis saepe quas fugit, beatae id quisquam.
        </p>
      </div>
      <div class="row">
          <c:forEach items="${ListDoctor}" var ="x">
        <div class="col-sm-6 col-lg-3 mx-auto">
          <div class="box"> 
            <div class="img-box">
              <img src="images/${x.img}" alt="">
            </div>
            <div class="detail-box">
              <div class="social_box">
                <a href="/profile?action=view&id=${x.id}">
                  <i class="fa fa-linkedin" aria-hidden="true"></i>
                </a>
              </div>
              <h5>
                ${x.name}
              </h5>
              <h6 class="">
                ${x.role.name}
              </h6>
            </div>
          </div>
        </div>
        </c:forEach>
       </div>
      <div class="btn-box">
        
      </div>
    </div>
  </section>

  <!-- end doctor section -->

  <!-- contact section -->
  <section class="contact_section layout_padding">
    <div class="container">
      <div class="heading_container">
        <h2>
          Feedback with system : 
        </h2>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="form_container contact-form">
              <form action="feedback" method="post">
              <div class="form-row">
              </div>
              <div>
                  <input type="text" class="message-box" required="" name="feedback" placeholder="Message" />
              </div>
              <div class="btn_box">
                <button>
                  SEND
                </button>
              </div>
            </form>
          </div>
        </div>
        <div class="col-md-6">
          <div class="map_container">
            <div class="map">
              <div id="googleMap"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- end contact section -->

  <!-- client section -->

<!--  <section class="client_section layout_padding-bottom">
    <div class="container">
      <div class="heading_container heading_center ">
        <h2>
          Testimonial
        </h2>
      </div>
      <div id="carouselExample2Controls" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="row">
              <div class="col-md-11 col-lg-10 mx-auto">
                <div class="box">
                  <div class="img-box">
                    <img src="images/client.jpg" alt="" />
                  </div>
                  <div class="detail-box">
                    <div class="name">
                      <h6>
                        Alan Emerson
                      </h6>
                    </div>
                    <p>
                      Enim consequatur odio assumenda voluptas voluptatibus esse nobis officia. Magnam, aspernatur nostrum explicabo, distinctio laudantium delectus deserunt quia quidem magni corporis earum inventore totam consectetur corrupti! Corrupti, nihil sunt? Natus.
                    </p>
                    <i class="fa fa-quote-left" aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="row">
              <div class="col-md-11 col-lg-10 mx-auto">
                <div class="box">
                  <div class="img-box">
                    <img src="images/client.jpg" alt="" />
                  </div>
                  <div class="detail-box">
                    <div class="name">
                      <h6>
                        Alan Emerson
                      </h6>
                    </div>
                    <p>
                      Enim consequatur odio assumenda voluptas voluptatibus esse nobis officia. Magnam, aspernatur nostrum explicabo, distinctio laudantium delectus deserunt quia quidem magni corporis earum inventore totam consectetur corrupti! Corrupti, nihil sunt? Natus.
                    </p>
                    <i class="fa fa-quote-left" aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="row">
              <div class="col-md-11 col-lg-10 mx-auto">
                <div class="box">
                  <div class="img-box">
                    <img src="images/client.jpg" alt="" />
                  </div>
                  <div class="detail-box">
                    <div class="name">
                      <h6>
                        Alan Emerson
                      </h6>
                    </div>
                    <p>
                      Enim consequatur odio assumenda voluptas voluptatibus esse nobis officia. Magnam, aspernatur nostrum explicabo, distinctio laudantium delectus deserunt quia quidem magni corporis earum inventore totam consectetur corrupti! Corrupti, nihil sunt? Natus.
                    </p>
                    <i class="fa fa-quote-left" aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="carousel_btn-container">
          <a class="carousel-control-prev" href="#carouselExample2Controls" role="button" data-slide="prev">
            <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExample2Controls" role="button" data-slide="next">
            <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
    </div>
  </section>-->

  <!-- end client section -->

  <!-- footer section -->
<jsp:include page="footer.jsp"></jsp:include>
  <!-- footer section -->

  <!-- jQery -->
  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
  <!-- popper js -->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
  </script>
  <!-- bootstrap js -->
  <script type="text/javascript" src="js/bootstrap.js"></script>
  <!-- owl slider -->
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
  </script>
  <!-- custom js -->
  <script type="text/javascript" src="js/custom.js"></script>
  <!-- Google Map -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
  </script>
  <!-- End Google Map -->

</body>
</html>
