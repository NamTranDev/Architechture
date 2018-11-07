/**
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ${packageName}

import nam.tran.domain.entity.${datato}
import nam.tran.flatform.model.response.${datafrom}
import java.util.*
import javax.inject.Inject

/**
 * Mapper class used to transform [${datafrom}] (in the <#if isDomain> in flatform layer<#else> in domain layer</#if>)
 * to [${datato}] in the
 * <#if isDomain> domain layer <#else> app layer</#if>.
 */
class ${DataMapperName} @Inject constructor() {

    /**
     * Transform a [${datafrom}] into an [${datato}].
     *
     * @param data Object to be transformed.
     * @return [${datato}].
     */
    fun transform(data: ${datafrom}?): ${datato} {
        if (data == null) {
            throw IllegalArgumentException("Cannot transform a null value")
        }

        return ${datato}()
    }

    /**
     * Transform a Collection of [${datafrom}] into a Collection of [${datato}].
     *
     * @param datas Objects to be transformed.
     * @return List of [${datato}].
     */
    fun transform(datas: List<${datafrom}>?): List<${datato}> {
        val <#if isDomain>dataEntitys<#else>dataModels</#if>: MutableList<${datato}>

        if (datas != null && !datas.isEmpty()) {
            <#if isDomain>dataEntitys<#else>dataModels</#if> = ArrayList()
            for (data in datas) {
                <#if isDomain>dataEntitys<#else>dataModels</#if>.add(transform(data))
            }
        } else {
            <#if isDomain>dataEntitys<#else>dataModels</#if> = ArrayList()
        }

        return <#if isDomain>dataEntitys<#else>dataModels</#if>
    }
}
