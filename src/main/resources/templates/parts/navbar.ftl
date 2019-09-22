<#assign known = Session.SPRING_SECURITY_CONTEXT??>
<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.getAuthorities()>
<#else>
    <#assign name = "unknown">
</#if>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand mb-0 h1" >Shop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/main">Main</a>
            </li>
            <li class="nav-item" >
                <a class="nav-link" href="/productpage">Products</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/cart">Cart<span class="badge badge-light cartSize"></span></a>
            </li>

            <#if isAdmin?join(",")?contains("ADMIN")>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/">Admin</a>
                </li>
            </#if>
        </ul>
        <button type="button" class="btn btn-light">
            <a href="/account">${name}</a><span class="glyphicon glyphicon-user"></span>
        </button>

        <form action="/logout" method="post">
            <button class="btn btn-outline-dark" id="logout" type="submit">Sign Out</button>
        </form>
    </div>
</nav>
<br>

