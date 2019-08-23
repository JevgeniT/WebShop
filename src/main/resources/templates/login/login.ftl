<#import "../parts/common.ftl" as c>
<@c.page>
    <form class="form-signin" action=${action} method="post">
        <h2 class="form-signin-heading">Please ${action}</h2>
        <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus/>
        <input type="password" class="form-control" name="password" placeholder="Password" />
        <#if action?contains("/login") >
            <h4 class="text-center"><a href="/registration">Create an account</a></h4>
        <#elseif action?contains("/registration")>
            <input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password" required=""/>
            <h4 class="text-center"><a href="/login">Back</a></h4>
        </#if>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        <#if message??>
            <div class="alert" role="alert">
                ${message}
            </div>
        </#if>
    </form>
</@c.page>



