package com.pandy.elasticsearch.service.impl;

import com.pandy.elasticsearch.model.User;
import lombok.val;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Service
public class SearchServiceImpl {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    public ArrayList getAll() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        SearchRequest searchRequest = new SearchRequest("user");
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.indicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN);
        searchSourceBuilder.query(QueryBuilders.termQuery("name", "lisi"));
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(5);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(searchSourceBuilder);
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", "wangwu");
        matchQueryBuilder.fuzziness(Fuzziness.AUTO);
        searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
        searchSourceBuilder.sort(new FieldSortBuilder("id").order(SortOrder.ASC));
        searchSourceBuilder.fetchSource(false);
        String[] includeFields = new String[] {"name", "id"};
        String[] excludeFields = new String[] {"age"};
        searchSourceBuilder.fetchSource(includeFields, excludeFields);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        HighlightBuilder.Field highLightName = new HighlightBuilder.Field("name");
        highlightBuilder.highlighterType("unified");
        HighlightBuilder.Field highLightUser = new HighlightBuilder.Field("name");
        highlightBuilder.field(highLightUser);
        searchSourceBuilder.highlighter(highlightBuilder);
        searchSourceBuilder.profile(true);
        SearchResponse searchResponse = elasticsearchRestTemplate.execute(client -> {
            return client.search(searchRequest, RequestOptions.DEFAULT);
        });
        final val hits = searchResponse.getHits();
        TotalHits totalHits = hits.getTotalHits();
        long numHits = totalHits.value;
        SearchHit[] searchHits = hits.getHits();
        User user = new User();
        ArrayList arrayList = new ArrayList();
        for (SearchHit searchHit : searchHits) {
            //searchHit.getFields();
            String sourceAsMapping = searchHit.getSourceAsString();
            final val sourceAsMap = searchHit.getSourceAsMap();
            final val name = sourceAsMap.get("name");
            user.setName((String) name);
        }
        arrayList.add(user);
        return arrayList;
    }
}
