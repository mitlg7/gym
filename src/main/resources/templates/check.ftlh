<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>

    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2482.2144649399693!2d45.982052215961!3d51.52762611704478!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4114c7aa7443a281%3A0xfa9c3268188dcac7!2z0JHQtdCz0L7QstCw0Y8g0YPQuy4sIDMvOSwg0KHQsNGA0LDRgtC-0LIsINCh0LDRgNCw0YLQvtCy0YHQutCw0Y8g0L7QsdC7LiwgNDEwMDU0!5e0!3m2!1sru!2sru!4v1639522818190!5m2!1sru!2sru" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>

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
                    <label for="email">Почта: </label>
                    <input name="email" type="text" class="form-control" id="email" placeholder="Емаил">
                </div>

                <div class="row">
                    <button type="submit" class="mx-auto col-8 btn btn-secondary mt-5 ">Проверить</button>
                </div>
            </#if>

            </#if>
            <#if valid??>
                <#if valid == "no">
                    <p class="fs-3">Пользователя с такой почтой нет</p>
                </#if>
                <#if valid == "yes">
                    <p class="fs-3">На вашу почту отправлено письмо</p>
                </#if>
            </#if>

        </div>

    </form>

</@component.skeleton>