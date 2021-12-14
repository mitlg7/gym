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


    </div>
</@component.skeleton>