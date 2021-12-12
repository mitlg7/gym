<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <div class="container " id="list-${subscription.id}" role="tabpanel" aria-labelledby="${subscription.id}">
        <p>Тренер: </p>
        <div class="card col-3 m-2" style="width: 18rem;">
            <#if subscription.trainer.gender.type == "Мужской">
                <img class="card-img-top" src="/img/men.png" alt="Card image cap">
            </#if>
            <#if  subscription.trainer.gender.type == "Женский">
                <img class="card-img-top" src="/img/women.png" alt="Card image cap">
            </#if>
            <div class="card-body">
                <h5 class="card-title">${ subscription.trainer.name}</h5>
                <p class="card-text">${ subscription.trainer.position.type}</p>
                <p class="card-text">${ subscription.trainer.phone}</p>
                <div class="btn btn-lg btn-danger">Записаться</div>
            </div>
        </div>
        <p>Зал: </p>
        <div class="card col-3 m-2" style="width: 18rem;">
            <img class="card-img-top" src="/img/hall.jpg" alt="">
            <div class="card-body">
                <h5 class="card-title">${subscription.hall.name}</h5>
            </div>
        </div>
    </div>
</@component.skeleton>