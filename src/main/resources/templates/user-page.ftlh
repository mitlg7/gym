<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    ${client.id}
    ${client.firstName}
    ${client.lastname}
    ${client.birthday}
    ${client.registration}

</@component.skeleton>