<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <div class="container fs-4 mt-4">
        <div class="row">
            <div class="col-12 row mb-4">
                <div class="col-3">
                    <#if client.gender.type == "Мужской">
                        <img class="img-thumbnail" src="/img/male.jpg">
                    <#else >
                        <img class="img-thumbnail" src="/img/female.jpg">
                    </#if>
                </div>
                <div class="col-9 fs-3">
                    <p>Пользователь: ${client.firstName} ${client.lastname}</p>
                    <p>Пол: ${client.gender.type} </p>
                    <p>Телефон: ${client.phone} </p>
                    <p>Дата рождения: ${client.birthday}</p>
                    <a class="btn btn-warning" href="/client/${client.id}">Назад к профилю</a>
                </div>
            </div>
            <div class="col-4">
                <div class="list-group" id="list-tab" role="tablist">
                    <p>Доступные абонементы для клиента</p>
                    <#list  subs as sub>
                        <a class="list-group-item list-group-item-action btn-warning" id="${sub.id}" data-toggle="list"
                           href="#list-${sub.id}" role="tab" aria-controls="${sub.id}ac">${sub.name} -
                            (${sub.continuance.type})</a>
                    </#list>
                </div>
            </div>
            <div class="col-8">
                <div class="tab-content" id="nav-tabContent">
                    <#list  subs as sub>
                        <div class="tab-pane fade" id="list-${sub.id}" role="tabpanel" aria-labelledby="${sub.id}">
                            <form method="post">
                                <p class="date theme-parent-text-color-alternate">Тренер: <label class="fs-4 fw-bold title theme-parent-text-color text-warning">${sub.trainer.name}
                                    - ${sub.trainer.position.type}</label></p>

                                <p class="description theme-parent-text-color">Отличный тренер, с огромным стажем. За
                                    свою карьеру воспитал несколько чемпионов. С ним вы добьетесь своей цели, будь то
                                    похудение, набор массы или повышение силовых показателей.</p>
                                <p class="date theme-parent-text-color-alternate">Зал: <label class="fw-bold fs-4 text-warning title theme-parent-text-color">${sub.hall.name}</label></p>

                                <p class="description theme-parent-text-color">Потрясающий новый зал. Новый тренажеры
                                    для каждого, большой выбор нагрузок, возможность посещать его в вечернее и утреннее
                                    время.</p>
                                <br>
                                <p>Длительность абонемента - <label class="fw-bold fs-3 text-warning">${sub.continuance.days} дней.</label><br>
                                    Начало сегодня - <label class="fw-bold fs-3 text-warning">${date}</label></p>
                                <p><label>Стоимость абонемента - </label><label class="fw-bold fs-3 text-warning">${sub.price}
                                        ₽</label></p>
                                <input hidden name="sub" value="${sub.id}">
                                <button>Продать</button>
                            </form>
                        </div>
                    </#list>
                </div>
            </div>
        </div>
    </div>



</@component.skeleton>