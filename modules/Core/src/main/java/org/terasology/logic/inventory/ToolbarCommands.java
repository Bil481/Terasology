/*
 * Copyright 2016 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.logic.inventory;

import org.terasology.entitySystem.systems.BaseComponentSystem;
import org.terasology.entitySystem.systems.RegisterSystem;
import org.terasology.logic.console.commandSystem.annotations.Command;
import org.terasology.logic.permission.PermissionManager;
import org.terasology.registry.Share;

/**
 *
 */
@RegisterSystem
@Share(ToolbarCommands.class)
public class ToolbarCommands extends BaseComponentSystem {
    private static boolean toolbarLabelsEnabled = true;
    @Command(value = "toolbarLabels", shortDescription = "Enable/disable key binding labels on toolbars", runOnServer = true,
            requiredPermission = PermissionManager.NO_PERMISSION)
    public String toolbarLabels() {
        toolbarLabelsEnabled = !toolbarLabelsEnabled;
        if(toolbarLabelsEnabled) {
            return "Toolbar key binding labels are enabled.";
        }
        return "Toolbar key binding labels are disabled.";
    }

    public static boolean getLabelsStatus() { return toolbarLabelsEnabled; }
}
