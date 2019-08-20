<#include "security.ftl">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" >Shop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/main">Main</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/productpage">Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/cart">Cart</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/">Admin </a>
            </li>
        </ul>
        <div class="navbar-text "><a href="/account">${name}</a></div>
        <form action="/logout" method="post">
            <button class="btn btn-outline-dark" type="submit">Sign Out</button>
        </form>
    </div>
</nav>

