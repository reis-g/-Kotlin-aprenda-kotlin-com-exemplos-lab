enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String, 
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()

    // Função para matricular um usuário na formação
    fun matricular(usuario: Usuario) {
        // Simulando a matrícula, adicionando o usuário à lista de inscritos
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("${usuario.nome} foi matriculado(a) com sucesso na formação $nome!")
        } else {
            println("${usuario.nome} já está matriculado(a) na formação $nome.")
        }
    }

    // Exibe todos os alunos matriculados
    fun listarInscritos() {
        println("Alunos matriculados na formação $nome:")
        inscritos.forEach { println(it.nome) }
    }
}

fun main() {
    // Criando conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Avançando com Kotlin", 120)
    val conteudo3 = ConteudoEducacional("Desenvolvimento de Apps", 150)

    // Criando uma formação
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin para Desenvolvedores", 
        nivel = Nivel.INTERMEDIARIO, 
        conteudos = listOf(conteudo1, conteudo2, conteudo3)
    )

    // Criando usuários (alunos)
    val aluno1 = Usuario("Carlos Souza")
    val aluno2 = Usuario("Maria Oliveira")
    val aluno3 = Usuario("João Silva")

    // Matrícula de alunos na formação
    formacaoKotlin.matricular(aluno1)
    formacaoKotlin.matricular(aluno2)
    formacaoKotlin.matricular(aluno3)

    // Tentando matricular um aluno que já está matriculado
    formacaoKotlin.matricular(aluno1)

    // Listando os alunos matriculados
    formacaoKotlin.listarInscritos()
}
