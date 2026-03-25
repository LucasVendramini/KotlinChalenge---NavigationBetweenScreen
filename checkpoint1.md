Explicação dos commits para o checkpoint:

1. Passagem de parâmetros obrigatórios na tela de perfil

*Main Activity*
// Define uma rota chamada "perfil" que recebe o parâmetro nome
composable(route = "perfil/{nome}") {
// Recupera o valor do argumento "nome" vindo da navegação
// Se não vier nada, usa "Usuário Genérico" como padrão
val nome: String? = it.arguments?.getString("nome", "Usuário Genérico")
// Chama a tela PerfilScreen
PerfilScreen(
// Aplica espaçamento interno na tela
modifier = Modifier.padding(innerPadding),
// Passa o controlador de navegação
navController,
// Força que nome não seja nulo
nome!!)
*MenuScreen*
// Define a ação executada ao clicar
onClick = {
// Navega para a rota "perfil"
// Passa o parâmetro "nome" com valor "Fulano de Tal"
// Esse valor será recebido na PerfilScreen
navController.navigate("perfil/Fulano de Tal") },
*PerfilScreen*
// Declara a função da tela PerfilScreen
fun PerfilScreen(
// Modifier permite customizar layout/estilo da tela, caso não passe nada já vem com valor padrão = Modifier
modifier: Modifier = Modifier,
// Controlador de navegação entre telas
navController: NavController,
// Parâmetro nome do tipo String que epresenta o nome recebido via navegação
nome: String
) {
*PerfilScreen*
// Define o texto que será exibido na tela
// "PERFIL -" é um texto fixo
// $nome insere o valor da variável nome na string
text = "PERFIL - $nome",

2. Passagem de parâmetros opcionais na tela de pedidos

*MainActivity*
// Importa a função navArgument da biblioteca de navegação do Android, usada para definir parâmetros nas rotas de navegação
import androidx.navigation.navArgument
*MainActivity*
composable(
// Define a rota da tela "pedidos" com um parâmetro chamado "cliente"
route = "pedidos?cliente={cliente}",
// Define os argumentos que essa rota aceita
arguments = listOf(navArgument("cliente") {
// Valor padrão caso nenhum cliente seja passado na navegação
defaultValue = "Cliente Genérico"
})
) {
// Conteúdo da tela quando essa rota é chamada
PedidosScreen(
// Aplica um padding (espaçamento) na tela
modifier = Modifier.padding(innerPadding),
// Passa o navController para controlar navegação dentro da tela
navController,
// Pega o valor do parâmetro "cliente" que veio pela navegação
// Se não existir é usado o valor padrão definido acima
it.arguments?.getString("cliente"))
*MainActivity*
PerfilScreen(
// Aplica um espaçamento interno na tela (geralmente vindo de Scaffold)
modifier = Modifier.padding(innerPadding),
// Passa o navController para permitir navegação dentro da tela
navController,
// Passa o nome para a tela Perfil
// O "!!" força que o valor não seja nulo
// Se for nulo o app vai dar erro (NullPointerException)
nome!!
)
*PedidosScreen*
fun PedidosScreen(
// Modifier permite customizar layout/estilo da tela, caso não passe nada já vem com valor padrão = Modifier
modifier: Modifier = Modifier,
// NavController é responsável por controlar a navegação entre telas
navController: NavController,
// Parâmetro cliente recebido
cliente: String?) {
*PedidosScreen*
// Define o texto que será exibido na tela
// "PEDIDOS -" é um texto fixo
// $cliente insere o valor da variável cliente dentro da string
text = "PEDIDOS - $cliente",

3. Inserindo valor ao parâmetro opcional na tela de Pedidos

*MenuScreen*
// Define a ação executada ao clicar
onClick = {
// Navega para a rota "pedidos" e envia o parâmetro "cliente" com valor "Cliente XPTO"
navController.navigate("pedidos?cliente=Cliente XPTO") },

4. Passagem de múltiplos parâmetros
*MainActivity*
// Importa o tipo NavType da biblioteca de navegação do Android, usado para definir o tipo dos parâmetros
import androidx.navigation.NavType
*MainActivity*
// Chama a tela PedidosScreen
PedidosScreen(
// Aplica um espaçamento interno na tela
modifier = Modifier.padding(innerPadding),
// Passa o navController
navController,
// Recupera o valor do argumento "cliente" vindo da navegação
// O "?" evita erro caso seja nulo
it.arguments?.getString("cliente")
)
*MainActivity*
composable(
// Define uma rota chamada "perfil" com dois parâmetros obrigatórios: nome e idade
route = "perfil/{nome}/{idade}",
// Lista de argumentos que essa rota espera
arguments = listOf(
// Define o argumento "nome" como tipo String
navArgument("nome") { type = NavType.StringType },
// Define o argumento "idade" como tipo Int
navArgument("idade") { type = NavType.IntType }
)
) {
*MainActivity*
// Declara uma variável chamada idade e tenta pegar o valor do argumento "idade" vindo da navegação
val idade: Int? = it.arguments?.getInt("idade", 0)
*MainActivity*
// Força que a variável nome NÃO seja nula
// Se for nula o app vai lançar erro (NullPointerException)
nome!!,
// Força que a variável idade NÃO seja nula
// Se for nula também gera erro
idade!!
*MenuScreen*
// Define a ação ao clicar no botão
onClick = {
// Navega para a rota "perfil" e passa dois parâmetros: "Fulano de Tal" → nome (String) e "27" → idade (Int)
navController.navigate("perfil/Fulano de Tal/27") },
*PerfilScreen*
// Parâmetro nome do tipo String (texto)
nome: String,
// Parâmetro idade do tipo Int (número inteiro)
idade: Int
*PerfilScreen*
// Define o texto que será exibido na tela
// "PERFIL -" é um texto fixo
// $nome insere o valor da variável nome
// $idade insere o valor da variável idade
text = "PERFIL - $nome tem $idade anos",