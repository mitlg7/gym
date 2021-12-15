<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <div class="container row col-12 mt-4">
        <div class="col-3">
            <#if client.gender.type == "Мужской">
                <img class="img-thumbnail" src="/img/male.jpg">
            <#else >
                <img class="img-thumbnail" src="/img/female.jpg">
            </#if>
        </div>
        <div class="col-6 fs-3">
            <p>Пользователь: ${client.firstName} ${client.lastname}</p>
            <p>Пол: ${client.gender.type} </p>
            <p>Телефон: ${client.phone} </p>
            <p>Дата рождения: ${client.birthday}</p>
        </div>
        <div class="col-3 text-center">
            <a class="btn btn-warning m-4" href="/client/${client.id}/accounting"> Управление абонементами пользователя</a>
            <form method="post" action="/admin/client/delete">
                <input hidden name="id" value="${client.id}">
                <button class="btn btn-danger">Удалить</button>
            </form>
        </div>
        <p class="fs-4 text-warning">Абонементы пользователя:</p>
        <div class="container">
            <#if accounting??>
                <#list accounting as acc>
                    <div class="card m-2">
                        <div class="card-header">
                            <a class="text-warning" href="/subscription/${acc.subscription.id}"></a>${acc.subscription.name}
                        </div>
                        <div class="card-body">
                            <p class="card-text">Начало: ${acc.start} <br> Конец: ${acc.end}</p>
                            <p class="card-text">Длительность: ${acc.subscription.continuance.days} дней</p>
                            <p class="card-text">Зал: ${acc.subscription.hall.name}<br>Тренер: ${acc.subscription.trainer.name}</p>
                        </div>
                    </div>
                </#list>
            <#else >
                <div>У пользователя пока нет абонемента.</div>
            </#if>

        </div>
    </div>


</@component.skeleton>