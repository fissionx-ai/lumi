package com.fissionx.lumi.transformers;

import com.fissionx.lumi.entity.Workspace;

public interface WorkspaceTransformer<A> {
    Workspace transformToWorkspace(A source);
    A transformToWorkspace(Workspace source);

}
