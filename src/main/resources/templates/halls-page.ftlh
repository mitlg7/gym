<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <div class="row container m-4">
        <#list halls as hal>
            <div class="card col-3 m-2" style="width: 18rem;">
                <img class="card-img-top" src="/img/hall.jpg" alt="">
                <div class="card-body">
                    <h5 class="card-title">${hal.name}</h5>
                </div>
            </div>
        </#list>
    </div>
</@component.skeleton>