<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <table id="clients" class="table table-dark table-hover mt-3">
        <thead>
        <tr>
            <th>ID</th>
            <th class="sorting_disabled">Имя</th>
            <th class="sorting_disabled">Фамилия</th>
            <th class="sorting_disabled">Телефон</th>
            <th class="sorting_disabled">Дата рождения</th>
            <th class="sorting_disabled">Дата регистрации</th>
            <th class="sorting_disabled">Пол</th>
            <th class="sorting_disabled"></th>
        </tr>
        </thead>
        <tbody>
        <#list clients as client>
            <tr style="cursor: pointer;">
                <td>${client.id}</a></td>
                <td>${client.firstName}</td>
                <td>${client.lastname}</td>
                <td>${client.phone}</td>
                <td>${client.birthday}</td>
                <td>${client.registration}</td>
                <td>${client.gender.type}</td>
                <td><a class="btn btn-warning" href="/client/${client.id}">Перейти в профиль</a></td>

            </tr>
        </#list>
        </tbody>
    </table>

</@component.skeleton>