<#import "parts/common.ftl" as c>
<@c.page>

<form class="form-signin" modelAttribute="userForm" action="/login" method="post" >
    <h2 class="form-signin-heading">Please login</h2>
    <input type="text" class="form-control" name="username" placeholder="Username" required autofocus />
    <input type="password" class="form-control" name="password" placeholder="Password" required autofocus />
    <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    <h4 class="text-center"><a href="registration">Create an account</a></h4>
    <#if error??>
        <div class="alert" role="alert">
            ${error}
        </div>
    </#if>
    <#if message??>
        <div class="alert" role="alert">
            ${message}
        </div>
    </#if>

</form>
</@c.page>


