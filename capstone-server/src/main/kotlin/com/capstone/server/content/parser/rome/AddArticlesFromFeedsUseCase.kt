import com.capstone.server.content.data.ArticleEntity
import com.capstone.server.content.data.ArticlesDataRepository
import com.capstone.server.content.parser.rome.FeedListProvider
import com.capstone.server.content.parser.rome.FeedParser
import org.springframework.stereotype.Component

interface AddArticlesFromFeedsUseCase {
    fun invoke( fileName: String)
}

@Component("addArticlesFromFeedsUseCase")
internal class AddArticlesFromFeedsUseCaseImpl(val feedParser: FeedParser,
                                               val feedListProvider: FeedListProvider,
                                               val articleDataRepository : ArticlesDataRepository
                                               ) : AddArticlesFromFeedsUseCase {
    override fun invoke(fileName: String) {
        val feedItems = feedListProvider.invoke(fileName)
        val listArticle = feedParser.invoke(feedItems)

        articleDataRepository.saveAll(listArticle.map { article ->
            ArticleEntity(
                    title = article.title,
                    url = article.url,
                    content = article.content,
                    publishedDate = article.publishedDate,
                    imageUrl = article.imageUrl,
                    author = article.author,
                    siteName = article.siteName
            )
        })
    }
}