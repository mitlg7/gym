<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <form method="post" action="/check" class="container col-4 mt-5">
        <#if error??>
        <p class="fs-3">${error}</p>
        <#else>
        <#if client??>
        <div class="container row col-12 mb-4">
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
            <#if accs??>
                <#list accs as acc>
                    <div class="card">
                        <div class="card-header">
                            <a class="text-warning"
                               href="/subscription/${acc.subscription.id}"></a>${acc.subscription.name}
                        </div>
                        <div class="card-body">
                            <p class="card-text">Начало: ${acc.start} Конец: ${acc.end}</p>
                            <p class="card-text">Длительность:${acc.subscription.continuance.days} дней</p>

                        </div>
                    </div>
                </#list>
            <#else >
                <p class="fs-3">У пользователя не абонементов</p>
            </#if>
            <#else>
                <div class="form-group">
                    <label for=" fs-4 mb-3">Ваша почта указанная про регистрации в клубе: </label>
                    <input name="email" type="text" class="form-control" id="email" placeholder="Емаил">
                </div>

                <div class="row">
                    <button type="submit" class="mx-auto col-8 btn btn-warning mt-5 btn-lg">Проверить</button>
                </div>
            </#if>

            </#if>
            <#if valid??>
                <#if valid == "no">
                    <p class="fs-5 mt-3">Пользователя с такой почтой нет</p>
                </#if>
                <#if valid == "yes">
                    <p class="fs-5 mt-3">На вашу почту отправлено письмо</p>
                </#if>
            </#if>

        </div>

    </form>

</@component.skeleton>