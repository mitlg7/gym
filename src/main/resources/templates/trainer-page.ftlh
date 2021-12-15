<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <div class="container row">
        <div class="col-3">
            <#if trainer.image??>
                <img class="img-thumbnail" src="/avatars/${trainer.image}">
            <#else >
                <#if trainer.gender.type == "Мужской">
                    <img class="img-thumbnail" src="/img/male.jpg">
                <#else >
                    <img class="img-thumbnail" src="/img/female.jpg">
                </#if>
            </#if>

        </div>
        <div class="col-6 fs-3">
            <p>Тренер: ${trainer.name}</p>
            <p>Должность: ${trainer.position.type}</p>
            <p>Пол: ${trainer.gender.type} </p>
            <p>Телефон: ${trainer.phone} </p>
            <p>Дата рождения: ${trainer.birthday}</p>

        </div>
        <p class="fs-4">Абонементы с этим тренером: </p>
        <div class="row container m-4">
            <#list subs as sub>
                <div class="card col-3 m-2" style="width: 18rem;">
                    <div class="card-body">
                        <img class="card-img-top" src="/img/top.jpg" alt="">
                        <h5 class="card-title mt-3">${sub.name}</h5>
                        <p class="card-text">Price ${sub.price}</p>
                        <p class="card-text">Time ${sub.continuance.days} days</p>
                        <a href="/map" class="btn btn-lg btn-warning">Записаться</a>
                    </div>
                </div>
            </#list>
        </div>


    </div>
</@component.skeleton>