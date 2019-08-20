<#import "../parts/common.ftl" as c>
<@c.page>
    <form method="post" class="form-signin" >
        <h2 class="form-signin-heading">Create your account</h2>

        <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus="" />

        <input type="password" class="form-control" name="password" placeholder="Password" required=""/>

        <input type="password" class="form-control" name="confirmPassword" placeholder="Password" required=""/>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        <h4 class="text-center"><a href="">Back</a></h4>

        <#if error??>
            <div class="alert" role="alert">
                ${error}
            </div>
        </#if>
    </form>
</@c.page>
