<%--
  Created by IntelliJ IDEA.
  User: Sami
  Date: 12/7/2023
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container newsletter mt-5 wow fadeIn" data-wow-delay="0.1s">
    <div class="row justify-content-center">
        <div class="col-lg-10 border rounded p-1">
            <div class="border rounded text-center p-1">
                <div class="bg-white rounded text-center p-5">
                    <h4 class="mb-4">Subscribe Our <span class="text-primary text-uppercase">Newsletter</span></h4>
                    <form method="post" action="newsletter_srv"id="myform">
                        <div class="position-relative mx-auto" style="max-width: 400px;">
                            <input class="form-control w-100 py-3 ps-4 pe-5" type="email" placeholder="Enter your email" id="emails" name="emails">
                            <button type="submit" class="btn btn-primary py-2 px-3 position-absolute top-0 end-0 mt-2 me-2" id="submitButton">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    document.getElementById('submitButton').addEventListener('click', function(event) {
        event.preventDefault(); // Prevent form from submitting normally

        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/newsletter_srv', true); // Replace with your form's action URL
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

        xhr.onload = function() {
            if (this.status == 200) {
                alert('Thanks');
            } else {
                // Handle error here
                console.error('An error occurred: ' + this.status);
            }
        };

        var formData = new FormData(document.getElementById('myForm'));
        xhr.send(new URLSearchParams(formData).toString());
    });
</script>
