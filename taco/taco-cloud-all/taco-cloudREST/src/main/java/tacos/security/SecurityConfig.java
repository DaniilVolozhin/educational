package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;*/

/*@Configuration*/
/*@EnableWebSecurity*/
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).
//                passwordEncoder(encoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests(). // возвращает объект которому можно указать :
//                antMatchers("/design", "/orders"). // url
//                access("hasRole('ROLE_USER')"). // роли для доступа
//                antMatchers("/", "/**").
//                access("permitAll()"). // все остальные запросы разрешены всем пользователям
//                and().
//                formLogin(). // найстройка пользовательской формы входы
//                loginPage("/login"). // путь к новой форме
///*                loginProcessingUrl("/authenticate"). // прослушивать запросы для входа по заданному url
//                usernameParameter("user"). // c параметром user
//                passwordParameter("pwd"); // и параметром pwd
//                // можно наладить когда будет время*/
//                defaultSuccessUrl("/design"). // после успешного входа в систему пользователь будет перенаправлен на указанный адрес
//        // если передать второй параметр true то всегда будет переход на design, не туда куда хотел пользователь после входа
//                and().
//                logout(). // выход из системы
//                logoutSuccessUrl("/"); // при успешном выходе перебрасывает на url
//                /*and().csrf().disable(); // отключает CSRF защиту*/
//
//    }

/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/design", "/orders"). // дальше это разрешить только по вторникам создавать Taco пользователям с ролью USER_ROLE
                access("hasRole('ROLE_USER') && T(java.util.Calendar).getInstance().get(T(java.util.Calendar).DAY_OF_WEEK == T(java.util.Calendar).TUESDAY").
                antMatchers("/", "/**").access("permitAll");
    }*/

/*
    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("52cr3t");
    }
*/


/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // храним пользователей в памяти
        auth.inMemoryAuthentication().// указывает что пользователи хранятся в памяти
                withUser("buzz").password("infinity").authorities("ROLE_USER").
                and().
                withUser("woody").password("bullseye").authorities("ROLE_USER");
    }*/

/*    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // хранение на основе JDBC
        auth.jdbcAuthentication().dataSource(dataSource).
                usersByUsernameQuery("select username, password, enabled from Users where username=?").
                authoritiesByUsernameQuery("select username, authority from UserAuthorities where username=?").
                passwordEncoder(new StandardPasswordEncoder("53cr3t"));// в базе хранятся зашифрованные данные
                            // с формы приходят данные шифруются и происходит проверка с зашифрованными данными в базе
    }*/

/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // хранилище пользователей в LDAP
        auth.ldapAuthentication().
                userSearchBase("ou=people"). // определяет базовый запрос для поиска групп
                userSearchFilter("(uid={0})").
                groupSearchBase("ou=group").
                groupSearchFilter("member={0}").
                passwordCompare(). // осуществляет сравнение паролей
                passwordEncoder(new BCryptPasswordEncoder()). // существляет шифрование пароля
                passwordAttribute("passcode"). // атрибут passcode должен сравниваться с заданным паролем
                and().
                contextSource().
                *//*url("ldap://tacocloud.com:389/dc=tacocloud,dc=com");// позволяет указать расположение LDAP сервера
                                                                    // если он развернут не на локальной машине*//*
                root("dc=tacocloud,dc=com"). // если сервер на локальной машине
                ldif("classpath:users.ldif"); // указывает файл с записями о пользователях
    }*/


//}
