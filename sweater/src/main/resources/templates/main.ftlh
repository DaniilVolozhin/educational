<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
   <div>
       <@l.logout />
   </div>
    <div>
        <form action="/main" method="post">
            <input type="text" name="text" placeholder="Введите сообщение" />
            <input type="text" name="tag" placeholder="Тег"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div>Список сообщений</div>
    <form action="/main" method="get">
        <input type="text" name="filter"  value="${filter}"/>
        <button type="submit">Найти</button>
    </form>
    <#list massages as message>
    <div>
        <b>${id}</b>
        <span>${text}</span>
        <i>${tag}</i>
        <strong>${authorName}</strong>
    </div>
        <#else>
        No massage
    </#list>
</@c.page>