<#import "components/skeleton.ftlh" as component>
<#import "components/nav.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    ${trainer.id}
    ${trainer.name}
    ${trainer.phone}
    ${trainer.birthday}

</@component.skeleton>