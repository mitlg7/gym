<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <div class="row container m-4">
        <#list subscriptions as sub>
            <div class="card col-3 m-2" style="width: 18rem;">
                <div class="card-body">
                    <img class="card-img-top" src="/img/top.jpg" alt="">
                    <h5 class="card-title mt-3">${sub.name}</h5>
                    <p class="card-text">Price ${sub.price}</p>
                    <p class="card-text">Time ${sub.continuance.days} days</p>
                    <div class="btn btn-lg btn-warning">Записаться</div>
                </div>
            </div>
        </#list>
    </div>
</@component.skeleton>