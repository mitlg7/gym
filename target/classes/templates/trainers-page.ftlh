<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <div class="row container m-4">
        <#list trainers as trainer>
            <div class="card col-3 m-2" style="width: 18rem;">
                <#if trainer.gender.type == "Мужской">
                    <img class="card-img-top" src="/img/men.png" alt="Card image cap">
                </#if>
                <#if trainer.gender.type == "Женский">
                    <img class="card-img-top" src="/img/women.png" alt="Card image cap">
                </#if>
                <div class="card-body">
                    <h5 class="card-title">${trainer.name}</h5>
                    <p class="card-text">${trainer.position.type}</p>
                    <p class="card-text">${trainer.phone}</p>
                    <div class="btn btn-lg btn-danger">Записаться</div>
                </div>
            </div>
        </#list>
    </div>
</@component.skeleton>