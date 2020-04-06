package de.andrestefanov.android.featuretoggles.model.data;

import java.util.List;

public class QueryResult<T> {

    private Long totalCount;

    private Boolean incompleteResults;

    private List<T> items;

    public Long getTotalCount() {
        return totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public List<T> getItems() {
        return items;
    }
}
