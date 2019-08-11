
<#import "common.ftl" as c>


<@c.page>
    <#include "navbar.ftl">

    <div class="container">

        <h2 class="text-center"><p class="font-weight-light"> Account details</p></h2>
        <hr>
        <div class="row">
            <div class="col-3">

                <h4 class="text-lg-left"><p class="font-weight-light">Name Lastname</p></h4>
                <hr>
                <p class="email note">asd@outlook.com</p>
                <div class="address note">
                    <p>asd 8-asd</p>
                    <p>city, </p>
                    <p>10616</p>
                    <p>num</p>
                </div>
            </div>
            <hr>
            <div class="col">
                <h4 class="text-left"><p class="font-weight-light">Order History</p></h4>
                <hr>
                <table class="table table-borderless table-sm">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">First</th>
                        <th scope="col">Last</th>
                        <th scope="col">Handle</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>


</@c.page>

